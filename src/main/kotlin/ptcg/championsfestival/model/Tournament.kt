package ptcg.championsfestival.model

import ptcg.championsfestival.db.TournamentEntity
import ptcg.championsfestival.exception.InvalidInputException
import java.time.Instant

data class Tournament(
    val tournamentId: Long,
    val tournamentName: String,
    val date: Instant,
    val region: String,
    val attendance: Int,
    val tournamentTier: TournamentTier,
    val setFormat: SetFormat,
    val tournamentFormat: TournamentFormat
) {
    // TODO: initialise this
    val tournamentStandings: Set<TournamentStandings> = setOf()

    val isStandard: Boolean = tournamentFormat == TournamentFormat.STANDARD
    val isMajorTournament: Boolean = tournamentTier.isMajorTournament()

    constructor(entity: TournamentEntity): this (
        entity.id, entity.tournamentName, entity.date, entity.region, entity.attendance,
        entity.tournamentTier, SetFormat.fromSetNames("${entity.startSetFormat}-${entity.endSetFormat}"),
        entity.tournamentFormat
    )
}

enum class TournamentTier {
    LEAGUE_CHALLENGE, LEAGUE_CUP, REGIONAL, SPE, INTERNATIONAL, WORLDS, UNKNOWN;

    companion object {
        fun from(key: String): TournamentTier =
            when (key) {
                "League Challenge" -> LEAGUE_CHALLENGE
                "League Cup" -> LEAGUE_CUP
                "Regional" -> REGIONAL
                "Special Event" -> SPE
                "International" -> INTERNATIONAL
                "Worlds" -> WORLDS
                else -> UNKNOWN
            }
    }

    fun isMajorTournament(): Boolean = when (this) {
        REGIONAL, SPE, INTERNATIONAL, WORLDS -> true
        else -> false
    }
}

enum class TournamentFormat {
    STANDARD, EXPANDED, UNKNOWN;

    companion object {
        fun from(key: String): TournamentFormat =
            when (key) {
                "Standard" -> STANDARD
                "Expanded" -> EXPANDED
                else -> UNKNOWN
            }
    }
}

data class SetFormat(
    val startCardSet: String,
    val endCardSet: String,
    val year: Int? = null,
    val startDate: String? = null,
    val endDate: String? = null,
) {
    companion object {
        fun fromSetNames(setNames: String): SetFormat {
            val sets: List<String> = setNames.split("-")
            if (sets.size != 2) {
                throw InvalidInputException("Not valid input for SetFormat")
            }
            // TODO: Return set format with set dates
            return SetFormat(sets[0], sets[1])
        }

        fun toSetNames(format: SetFormat): String = "${format.startCardSet}-${format.endCardSet}"
        fun toSetNames(start: String, end: String): String = "$start-$end"
    }
}

data class RawTournamentStandings(
    val standingId: String,
    val tournamentId: String,
    val playerId: String,
    val deckId: String,
    val placing: Int
) {

}

data class TournamentStandings(
    val playerName: String,
    val deck: Deck,
    val placing: Int
)

data class NewTournamentRequest(
    val tournamentName: String,
    val date: Instant,
    val region: String,
    val attendance: Int,
    val tournamentTier: String,
    val setFormat: String,
    val tournamentFormat: String
)