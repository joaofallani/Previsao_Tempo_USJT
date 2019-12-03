package br.usjt.PrevtempArq.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.usjt.PrevtempArq.model.Clima;

import java.util.List;


public interface ClimasRepository extends JpaRepository<Clima, Long> {

    
    /*------------------------------------------------QUERY E ASSICRONAS-----------------------------------------------------------------*/

	@Async
    @Query("select p from Clima p inner join p.cidade c where c.id = p.id and upper(c.nome) = upper(:nome)")
    List<Clima> findAllByCidade_Nome(@Param("nome") String nome);
	
	@Async
    @Query("select p from Clima p inner join p.cidade c where c.id = p.id and c.latitude = :latitude and c.longitude = :longitude")
    List<Clima> findAllByCidade_LatitudeAndCidade_Longitude(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
	
	List<Clima> findAllByCidade_NomeIgnoreCase(String nome);

    

    List<Clima> BuscaPeloCidadeNome (@Param("nome") String nome);

    List<Clima> BuscaPeloLatELon(@Param("latitude") Double latitude,@Param("longitude") Double longitude);
    
   

}
