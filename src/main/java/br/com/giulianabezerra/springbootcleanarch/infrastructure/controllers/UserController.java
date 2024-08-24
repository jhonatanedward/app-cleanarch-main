package br.com.giulianabezerra.springbootcleanarch.infrastructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giulianabezerra.springbootcleanarch.application.usecases.CreateUserInteractor;
import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;

@RestController
@RequestMapping("users")
public class UserController {
  private final CreateUserInteractor createUserInteractor;
  private final UserDTOMapper userDTOMapper;

  public UserController(CreateUserInteractor createUserInteractor, UserDTOMapper userDTOMapper) {
    this.createUserInteractor = createUserInteractor;
    this.userDTOMapper =  userDTOMapper;
  }

  @PostMapping
  CreateUserResponse create(@RequestBody CreateUserRequest user) {
    User userBusinessObj = userDTOMapper.toUser(user);
    return userDTOMapper.toResponse(createUserInteractor.createUser(userBusinessObj));
  }
}
