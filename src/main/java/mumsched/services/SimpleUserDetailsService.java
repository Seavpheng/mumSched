//package mumsched.services;
//
//import mumsched.domain.User;
//import mumsched.repositories.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.util.StringUtils;
//
//public class SimpleUserDetailsService implements UserDetailsService{
//    private UserRepository userRepository;
//
//    public SimpleUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String[] usernameAndDomain = StringUtils.split(username, String.valueOf(Character.LINE_SEPARATOR));
//        if (usernameAndDomain == null || usernameAndDomain.length != 2) {
//            throw new UsernameNotFoundException("Username and domain must be provided");
//        }
//        User user = userRepository.findUser(usernameAndDomain[0], usernameAndDomain[1]);
//        if (user == null) {
//            throw new UsernameNotFoundException(
//                    String.format("Username not found for domain, username=%s, domain=%s",
//                            usernameAndDomain[0], usernameAndDomain[1]));
//        }
//        return user;
//    }
//}
