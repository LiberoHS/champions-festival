package ptcg.championsfestival.controller

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ptcg.championsfestival.domain.DomainFactory
import ptcg.championsfestival.model.NewTournamentRequest
import ptcg.championsfestival.model.Tournament
import ptcg.championsfestival.service.ResultsService

@Controller
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api")
class TournamentController(
    private val domainFactory: DomainFactory,
    private val resultsService: ResultsService
) {

    companion object {
        val log = KotlinLogging.logger {}
    }

    @GetMapping("/tournaments")
    fun getListOfTournaments(): ResponseEntity<List<Tournament>> {
        // TODO: not paginated (CHF-18)
        val tournamentList = resultsService.getAllTournaments()
        return ResponseEntity.ok().body(tournamentList)
    }

    @PostMapping("/tournaments")
    fun addTournament(@RequestBody request: NewTournamentRequest): ResponseEntity<Tournament> {
        log.info { "Adding new tournament: $request" }
        val newTournament = resultsService.createNewTournament(request)
        return ResponseEntity.ok().body(newTournament)
    }

    @GetMapping("/tournaments/{tournamentId}")
    fun getTournamentDetailsById(@PathVariable tournamentId: Long): ResponseEntity<Tournament> {
        val tournament = domainFactory.tournaments(tournamentId).details()
        return if (tournament == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(tournament)
        }
    }

    @PutMapping("/tournaments/{tournamentId}")
    fun updateTournamentDetails(@PathVariable tournamentId: Long, @RequestBody details: Tournament) {
        resultsService.updateTournamentDetails(tournamentId, details)
    }

    @DeleteMapping("/tournaments/{tournamentId}")
    fun deleteTournamentById(@PathVariable tournamentId: Long) {
        resultsService.deleteTournament(tournamentId)
    }
}