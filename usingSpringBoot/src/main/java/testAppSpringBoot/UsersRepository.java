package testAppSpringBoot;

// This will be AUTO IMPLEMENTED by Spring into a Bean called postRepository
// CRUD refers Create, Read, Update, Delete

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

}