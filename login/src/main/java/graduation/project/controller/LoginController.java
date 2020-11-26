package graduation.project.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import graduation.project.common.contant.SecurityConstant;
import graduation.project.common.result.Result;
import graduation.project.common.status.HttpStatus;
import graduation.project.common.util.StringUtils;
import graduation.project.util.JWTUtils;
import graduation.project.service.AccountService;
import graduation.project.service.impl.CaptchaService;
import graduation.project.pojo.vo.CaptchaVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author 邝明山
 * on 2020/10/30 14:57
 */
@RestController
public class LoginController {
    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountService accountService;
    @Autowired
    private DefaultKaptcha producer;

    @Autowired
    private CaptchaService captchaService;

    @PostMapping(SecurityConstant.LOGIN)
    public Result login(@RequestParam(value="username") String username, @RequestParam(value="password")String password, @RequestParam(value="imageCode")String imageCode,@RequestParam(value="captchaKey")String captchaKey, HttpServletRequest request) throws Exception {
        String str = (String) redisTemplate.opsForValue().get("captcha:verification:".concat(captchaKey));
        redisTemplate.delete("captcha:verification:".concat(captchaKey));
/*        if(StringUtils.isBlank(str)){
            return Result.error(HttpStatus.MOVED_PERM,"图片验证码已过期");
        }
        if (!str.toLowerCase().equals(imageCode.toLowerCase())) {
            return Result.error(500, "图片验证码不匹配");
        }*/
        Collection<? extends GrantedAuthority> authorities;
        try {
            //这里使用authenticationManager验证，最终还会用到Config中设置的userDetailsService的loadUserByUsername方法
            //也可以直接用userDetailsService进行验证，反正只是为了封装JWT信息
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            authorities = authenticationManager.authenticate(token).getAuthorities();
        } catch (BadCredentialsException e) {
            return Result.error(401, "账户密码不匹配");
        }
        UserDetails userDetails = User.builder().username(username).password(password).authorities(authorities).build();
        String jwt = jwtUtils.createToken(userDetails);
        redisTemplate.opsForValue().set("jwt:"+username, jwt, 30 * 60, TimeUnit.SECONDS);

        return Result.success(jwt);
    }

    /*    @ApiOperation("这个无法通过swagger查看，请直接使用html中src查看，例如<img  src=\"http://IP地址:端口号/IMAGEVALIDATE\">")
        @GetMapping(SecurityConstant.IMAGE_VALIDATE)
        public void   ImageValidateByStream(HttpServletRequest request,HttpServletResponse response) throws IOException {
            //用我们的验证码类，生成验证码类对象
            ImageVerificationCode ivc = new ImageVerificationCode();
            BufferedImage image = ivc.getImage();
            //将验证码的文本存在session中
            request.getSession().setAttribute("imageCode", ivc.getText());
            ImageVerificationCode.output(image, response.getOutputStream());
        }*/
    @ApiOperation("查看图片：请直接使用html中src查看，例如<img src=\"data:image/jpeg;base64,base64 编码的 jpeg 图片数据\" />")
    @GetMapping(SecurityConstant.IMAGE_VALIDATE)
    public Result getCaptcha() throws IOException {
        // 生成文字验证码
        String content = producer.createText();
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(content);

        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray()).replace("\n", "").replace("\r", "");

        CaptchaVO captchaVO = captchaService.cacheCaptcha(content);
        captchaVO.setBase64Img(base64Img);

        return Result.success(captchaVO);
    }
}
