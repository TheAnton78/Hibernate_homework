package ru.netology.sql_hibirnate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.sql_hibirnate.model.CompositeKey;
import ru.netology.sql_hibirnate.model.Person;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, CompositeKey> {
    @Query("select p from Person p where p.cityOfLiving = : city")
    List<Person> findByCityOfLiving(@Param("city")String cityOfLiving);

    @Query("select p from Person p where p.id.age < : age")
    List<Person> findByAgeLessThanOrderByAge(@Param("age")Integer age, Sort sort);

    @Query("select p from Person p where p.id.name = : name and p.id.surname = : surname")
    List<Person> findByNameAndSurnameLike(@Param("name") String name, @Param("surname")String surname);

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<?> getPersonsByCity(String city){
//        return (List<?>) entityManager.createQuery("SELECT person from Person person where cityOfLiving = ?1")
//                .setParameter(1, city.toUpperCase()).getResultList();
//    }

}
