
package airbnbteam.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="member", url="http://member:8080")
public interface MemberService {

    @RequestMapping(method= RequestMethod.POST, path="/members")
    public void restoreMileage(@RequestBody Member member);

}