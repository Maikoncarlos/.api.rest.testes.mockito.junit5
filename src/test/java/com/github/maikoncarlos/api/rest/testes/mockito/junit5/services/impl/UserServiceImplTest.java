package com.github.maikoncarlos.api.rest.testes.mockito.junit5.services.impl;

import com.github.maikoncarlos.api.rest.testes.mockito.junit5.domain.User;
import com.github.maikoncarlos.api.rest.testes.mockito.junit5.domain.dto.UserDTO;
import com.github.maikoncarlos.api.rest.testes.mockito.junit5.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID       = 1;
    public static final String NAME      = "Maikon";
    public static final String EMAIL     = "maikon@gmail.com";
    public static final String PASSWORD  = "123";
    @InjectMocks
    private UserServiceImpl serviceImpl;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> userOpt;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsers();
    }

    @Test
    @DisplayName("Quando chamar o metodo findById retorne uma instancia de User")
    void whenFindByIdThenReturnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(userOpt);

        User response = serviceImpl.findById(ID);

        assertNotNull(response, "não pode ser nulo");
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());

    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUsers(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        userOpt = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}