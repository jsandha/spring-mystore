package org.sandha.store.repositories;

import lombok.Getter;
import org.sandha.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}