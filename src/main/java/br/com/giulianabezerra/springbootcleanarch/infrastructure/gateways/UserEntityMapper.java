package br.com.giulianabezerra.springbootcleanarch.infrastructure.gateways;

import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;
import br.com.giulianabezerra.springbootcleanarch.infrastructure.persistence.UserEntity;

public class UserEntityMapper {
    UserEntity toEntity(User userDomain) {
        return new UserEntity(userDomain.username(), userDomain.senha(), userDomain.email());
    }
    
    User toDomain(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    } 
}
