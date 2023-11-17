package webshop.shopapi.service.impl;


import webshop.shopapi.entity.Cart;
import webshop.shopapi.entity.User;
import webshop.shopapi.enums.ResultEnum;
import webshop.shopapi.exception.MyException;
import webshop.shopapi.repository.CartRepository;
import webshop.shopapi.repository.UserRepository;
import webshop.shopapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    @Transactional
    public User save(User user) {
        //register
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            User savedUser = userRepository.save(user);

            // initial Cart
            Cart savedCart = cartRepository.save(new Cart(savedUser));
            savedUser.setCart(savedCart);

            emailService.sendEmail(user.getEmail(), "Uspesna registracija", "Hvala Vam sto ste se registrovali");
            return userRepository.save(savedUser);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }

    }

    @Override
    @Transactional
    public User update(User user) {
        User oldUser = userRepository.findByEmail(user.getEmail());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setUlica(user.getUlica());
        oldUser.setBroj(user.getBroj());
        oldUser.setBrojStana(user.getBrojStana());
        oldUser.setSprat((user.getSprat()));
        oldUser.setInterfon(user.getInterfon());
        oldUser.setPhone(user.getPhone());

        return userRepository.save(oldUser);
    }

}
