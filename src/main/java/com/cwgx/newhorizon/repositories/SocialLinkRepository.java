package com.cwgx.newhorizon.repositories;
import com.cwgx.newhorizon.model.SocialLink;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface SocialLinkRepository extends CrudRepository<SocialLink, Integer> {
    @Query(value = "SELECT * FROM social_link WHERE id_social_link = ?1", nativeQuery = true)
    SocialLink socialFindById(Integer id);
}
