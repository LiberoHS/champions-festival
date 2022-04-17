package ptcg.championsfestival.db

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "tournaments", path = "tournaments")
interface TournamentRepository: CrudRepository <TournamentEntity, Long> {
}