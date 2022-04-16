package ptcg.championsfestival.controller

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ptcg.championsfestival.domain.DomainFactory

@Controller
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api")
class TournamentController(
    private val domainFactory: DomainFactory
) {

    companion object {
        val log = KotlinLogging.logger {}
    }

    @GetMapping("/tournaments")
    fun getListOfTournaments(): ResponseEntity<Void> {
        return ResponseEntity.ok().build()
    }

    @GetMapping("/tournaments/{tournamentId}")
    fun getTournamentDetailsById(@PathVariable tournamentId: Int): () -> Unit {
        return domainFactory.tournaments(tournamentId).details()
    }
}