package com.team.cwl.member;
//package com.team.cwl.member;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import oracle.sql.json.OracleJsonObject;
//
//@Controller
//@RequestMapping("/api/kakao")
//public class KakaoController {
//	
//	public KakaoController() {
//    }
//
//    @GetMapping(value = "/oauth")
//    public String kakaoConnect() {
//        StringBuffer url = new StringBuffer();
//        url.append("https://kauth.kakao.com/oauth/authorize?");
//        url.append("client_id=" + "c871225467c7a2616f29a93e7f571eea");
//        url.append("&redirect_uri=http://localhost:8080/kakao/callback");
//        url.append("&response_type=code");
//
//        return "redirect:" + url;
//    }
//	
//    @RequestMapping(value = "/callback", produces = "application/json", method = {RequestMethod.GET,
//            RequestMethod.POST})
//        public void kakaoLogin(@RequestParam("code") String code,
//            HttpSession session) throws IOException {
//
//            String accessToken = getKakaoAccessToken(code);
//            session.setAttribute("access_token", accessToken); // �α׾ƿ��� �� ���ȴ�
//        }
//        
//       public String getKakaoAccessToken(String code) {
//            // īī���� ���� api
//            WebClient webClient = WebClient.builder()
//                .baseUrl("https://kauth.kakao.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//            
//            // īī�� ������ ��û ������ & ���� �ޱ�
//            OracleJsonObject response = webClient.post()
//                .uri(uriBuilder -> uriBuilder
//                    .path("/oauth/token")
//                    .queryParam("grant_type", "authorization_code")
//                    .queryParam("client_id", SecretKey.KAKAO_API_KEY)
//                    .queryParam("redirect_uri", Kakao.DOMAIN_URI + "/api/kakao/callback")
//                    .queryParam("code", code)
//                    .build())
//                .retrieve().bodyToMono(OracleJsonObject.class).block();
//                
//                return (String) response.get("access_token");
//        }
//    
//}
