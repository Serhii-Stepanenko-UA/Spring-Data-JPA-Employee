package org.example.app.repository;

import org.example.app.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Репозиторії, зокрема, призначені визначення логіки для шару збереження.
// JpaRepository приймає клас сутності, а також тип даних ID,
// який він повинен використовувати для запиту.
@Qualifier("employeeRepository")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Значення частин назви методу findFirstByOrderByIdDesc():
    // - find повідомляє Spring Data JPA створити запит на вибірку.
    // - First вказує, що потрібно отримати перший запис із набору
    // результатів.
    // - OrderByIdDesc означає, що хочемо відсортувати записи
    // у зворотному порядку за властивістю id сутності Employee.
    //
    // Тут, Spring Data JPA інтелектуально оцінює назву методу.
    // Спочатку сортуються записи в порядку спадання за id.
    // Таким чином, останній запис розміщується на початку результату.
    // Потім, findFirst інтерпретується для повернення першого елемента
    // відсортованих записів.
    // Результат: маємо отримати останній запис таблиці.
    Optional<Employee> findFirstByOrderByIdDesc();

    // Значення частин назви методу findByFirstName(String firstName):
    // - find повідомляє Spring Data JPA створити запит на вибірку.
    // - FirstName вказує, що потрібно отримати запис(и) із набору
    // результатів за властивістю firstName сутності Employee,
    // що має збігатися зі значенням параметра firstName цього методу.
    // Результат: маємо отримати колекцію відповідних записів.
    Optional<List<Employee>> findByFirstName(String firstName);

    // Значення частин назви методу findByLastName(String lastName):
    // - find повідомляє Spring Data JPA створити запит на вибірку.
    // - LastName вказує, що потрібно отримати запис(и) із набору
    // результатів за властивістю lastName сутності Employee,
    // що має збігатися зі значенням параметра lastName цього методу.
    // Результат: маємо отримати колекцію відповідних записів.
    Optional<List<Employee>> findByLastName(String lastName);
}
