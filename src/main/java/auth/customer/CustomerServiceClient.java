package auth.customer;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="customer-service", url="${customerService.url}")
public interface CustomerServiceClient {
	@RequestMapping(method=RequestMethod.GET, value="/customer/rest/customer/search")
	List<Customer> getCustomerByUsername(@RequestParam(value="username", required=true) String username);

	@RequestMapping(method=RequestMethod.GET, value="/customer/rest/customer/check")
	void healthCheck();

}
