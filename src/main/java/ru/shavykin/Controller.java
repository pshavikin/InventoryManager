package ru.shavykin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.shavykin.model.Product;
import ru.shavykin.repository.ProductRepository;
import ru.shavykin.repository.UserRepository;

import java.util.List;

@RestController
public class Controller {

    private ProductRepository repository;
    public UserRepository userRepository;


    @Autowired
    public Controller(ProductRepository repository, UserRepository userRepository) {
        this.userRepository=userRepository;
        this.repository = repository;
    }

    @GetMapping("/start")
    ResponseEntity<String> healthStatus() {
        return new ResponseEntity<>("good", HttpStatus.OK);
    }

    @GetMapping("/findByName")
    ResponseEntity<List<Product>> findByName (@RequestParam String name) {
        List list = repository.findByName(name);
        if (list.size() <= 0)
            return new ResponseEntity("Подходящих продуктов нет", HttpStatus.I_AM_A_TEAPOT);
        ResponseEntity response = new ResponseEntity(list, HttpStatus.OK);
        return response;
    }
    @GetMapping("/findByBrand")
    ResponseEntity<List<Product>> findByBrand (@RequestParam String brand) {
        List list = repository.findByBrand(brand);
        if (list.size() <= 0)
            return new ResponseEntity("Подходящий продуктов нет", HttpStatus.I_AM_A_TEAPOT);
        ResponseEntity responce = new ResponseEntity((list), HttpStatus.OK);
        return responce;

    }


    @GetMapping("/checkLess5")
    public ResponseEntity<List<Product>> productsLessFive() {
        List list = repository.findByQuantityLessThan(5);
        if (list.size() <= 0)
            return new ResponseEntity("Подходящих продуктов нет", HttpStatus.I_AM_A_TEAPOT);
        ResponseEntity response = new ResponseEntity(list, HttpStatus.OK);
        return response;
    }
}






