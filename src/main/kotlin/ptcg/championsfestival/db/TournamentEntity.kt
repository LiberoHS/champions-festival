package ptcg.championsfestival.db

import javax.persistence.Entity
import ptcg.championsfestival.model.TournamentFormat
import ptcg.championsfestival.model.TournamentTier
import java.time.Instant
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TournamentEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long = -1,
    var tournamentName: String,
    var date: Instant,
    var region: String,
    var attendance: Int,
    var tournamentTier: TournamentTier,
    val startSetFormat: String,
    val endSetFormat: String,
    val tournamentFormat: TournamentFormat
)