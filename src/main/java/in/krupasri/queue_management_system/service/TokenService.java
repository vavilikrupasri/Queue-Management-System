package in.krupasri.queue_management_system.service;

import in.krupasri.queue_management_system.entity.Customer;
import in.krupasri.queue_management_system.entity.Token;
import in.krupasri.queue_management_system.entity.TokenStatus;
import in.krupasri.queue_management_system.repository.CustomerRepository;
import in.krupasri.queue_management_system.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;


    @Autowired
    private CustomerRepository customerRepository;

    public Token generateToken(Integer customerId){

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->new RuntimeException("Customer not found"));


        Token lastToken = tokenRepository.findTopByOrderByTokenNumberDesc();

        Token token =  new Token();
        if(lastToken == null){
            token.setTokenNumber(101);
        }else{
            token.setTokenNumber(lastToken.getTokenNumber()+1);
        }
        token.setCustomer(customer);
        token.setStatus(TokenStatus.WAITING);
        return tokenRepository.save(token);

    }
    public List<Token> getAllTokens(){
        return tokenRepository.findAll();
    }

    public Token getTokenBYId(Integer id){
        return tokenRepository.findById(id).orElseThrow(()-> new RuntimeException("Token not found"));
    }

    public List<Token> getWaitingTokens(){
        return tokenRepository.findByStatus(TokenStatus.WAITING);
    }

    public Token callNextToken(){
       Token token = tokenRepository.findFirstByStatusOrderByTokenNumberAsc(TokenStatus.WAITING)
                .orElseThrow(() -> new RuntimeException("No Waiting tokens"));
        token.setStatus(TokenStatus.SERVING);
        return tokenRepository.save(token);

    }

    public Token completeToken(){
        Token token = tokenRepository.findFirstByStatusOrderByTokenNumberAsc(TokenStatus.SERVING)
                .orElseThrow(() -> new RuntimeException("No Serving Tokens"));
                token.setStatus(TokenStatus.COMPLETED);
                return tokenRepository.save(token);
    }



}