package com.example.restfulwebservicenew.dao;

import com.example.restfulwebservicenew.bean.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//@Component
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "Benzam", new Date(), "test1", "111111-1111111"));
        users.add(new User(2, "Wooya", new Date(), "test1", "111111-1111111"));
        users.add(new User(3, "Gina", new Date(), "test1", "111111-1111111"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        //리스트 형태의 데이터 값을 순차적으로 접근해서 사용하기 위한 열거형 타입의 데이터를 이터레이터라고 함
        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return  null;
    }


}

