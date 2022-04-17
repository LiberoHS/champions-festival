package ptcg.championsfestival.service

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ptcg.championsfestival.db.TournamentEntity
import ptcg.championsfestival.db.TournamentRepository
import ptcg.championsfestival.model.NewTournamentRequest
import ptcg.championsfestival.model.SetFormat
import ptcg.championsfestival.model.Tournament
import ptcg.championsfestival.model.TournamentFormat
import ptcg.championsfestival.model.TournamentTier

@Service
class ResultsService(
    private val repo: TournamentRepository
) {
    companion object {
        val log = KotlinLogging.logger {}
    }

    fun getAllTournaments(): List<Tournament> {
        log.debug { "Retrieving all completed tournaments" }
        val entities = repo.findAll()
        return entities.map { Tournament(it) }
    }

    fun getTournamentById(tournamentId: Long): Tournament? {
        val entity = findEntity(tournamentId) ?: return null
        return Tournament(entity)
    }

    fun createNewTournament(request: NewTournamentRequest): Tournament {
        val newTournament = createTournamentEntity(request)
        log.info { "Appending tournament $newTournament into db" }
        repo.save(newTournament)
        return Tournament(newTournament)
    }

    fun updateTournamentDetails(tournamentId: Long, details: Tournament) {
        log.info { "Updating tournament: ${details.tournamentId} with details: $details" }
        val entity = findEntity(tournamentId) ?: return
        repo.deleteById(entity.id)
        val updatedEntity = createTournamentEntity(details)
        repo.save(updatedEntity)
    }

    fun deleteTournament(tournamentId: Long) {
        val entity = findEntity(tournamentId) ?: return
        log.info { "Deleting tournament $entity" }
        repo.deleteById(tournamentId)
    }

    private fun findEntity(tournamentId: Long): TournamentEntity? {
        val entity = repo.findById(tournamentId)
        if (entity.isEmpty) {
            log.warn { "Cannot find tournament with id: $tournamentId" }
            return null
        }
        return entity.get()
    }

    private fun createTournamentEntity(tournament: Tournament): TournamentEntity {
        tournament.run {
            return TournamentEntity(
                id = tournamentId,
                tournamentName = tournamentName,
                date = date,
                region = region,
                attendance = attendance,
                tournamentTier = tournamentTier,
                startSetFormat = setFormat.startCardSet,
                endSetFormat = setFormat.endCardSet,
                tournamentFormat = tournamentFormat
            )
        }
    }

    private fun createTournamentEntity(request: NewTournamentRequest): TournamentEntity {
        request.run {
            val sets = SetFormat.fromSetNames(setFormat)
            return TournamentEntity(
                tournamentName = tournamentName,
                date = date,
                region = region,
                attendance = attendance,
                tournamentTier = TournamentTier.from(tournamentTier),
                startSetFormat = sets.startCardSet,
                endSetFormat = sets.endCardSet,
                tournamentFormat = TournamentFormat.from(tournamentFormat)
            )
        }
    }
}