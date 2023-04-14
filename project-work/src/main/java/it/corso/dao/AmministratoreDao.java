package it.corso.dao;




import org.springframework.data.repository.CrudRepository;



import it.corso.model.Amministratore;

public interface AmministratoreDao extends CrudRepository<Amministratore, Integer>{
	
//	@Query
//	(value= "SELECT username FROM amministratori WHERE username =:u ", nativeQuery = true)
//	String getUsernameAdmin(@Param("u") String username);
	
	
	Amministratore findByUsernameAndPassword(String username,String password);
	
	
	
//	@Query(value= "SELECT COUNT(*) > 0 FROM amministratori WHERE username = :u", nativeQuery = true)
//	boolean existsByUsername(@Param("u") String username);
//	
//	@Query(value= "SELECT COUNT(*) > 0 FROM amministratori WHERE password = :p", nativeQuery = true)
//	boolean existsByPassword(@Param("p") String password);
//	
//	@Query
//	(value= "SELECT password FROM amministratori WHERE password =:p ", nativeQuery = true)
//	String getPasswordAdmin(@Param("p") String password);
}



