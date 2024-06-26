package com.application.userauth.model;

import com.application.userauth.entity.UserEntity;
import com.application.userauth.exception.ErrorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ModelEntityTest {

    @Test
    @DisplayName("Testing All Models and Entities")
    void test_model_entity(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(UserModel.class);
        beanTester.testBean(UserEntity.class);
        beanTester.testBean(ErrorModel.class);
    }
}
