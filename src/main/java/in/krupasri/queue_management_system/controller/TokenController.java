package in.krupasri.queue_management_system.controller;

import in.krupasri.queue_management_system.entity.Token;
import in.krupasri.queue_management_system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Token> generateToken(@RequestParam Integer customerId) {

        Token token = tokenService.generateToken(customerId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(token);
}

@GetMapping
    public ResponseEntity<List<Token>> getAllTokens(){
        List<Token> tokens = tokenService.getAllTokens();
        return ResponseEntity.ok(tokens);
}

@GetMapping("/{id}")
    public ResponseEntity<Token> getTokenBYId(@PathVariable Integer id){
        Token tokens = tokenService.getTokenBYId(id);
        return ResponseEntity.ok(tokens);

}
@GetMapping("/waiting")
    public ResponseEntity<List<Token>> getWaitingTokens(){
        List<Token> tokens = tokenService.getWaitingTokens();
        return ResponseEntity.ok(tokens);
}

@PutMapping ("/call-next")
    public ResponseEntity<Token> callNextToken(){
        Token token = tokenService.callNextToken();
        return ResponseEntity.ok(token);
}
@PutMapping("/complete")
    public ResponseEntity<Token> completeToken(){
        Token token = tokenService.completeToken();
        return ResponseEntity.ok(token);
}




}