package ptcg.championsfestival.model

import java.time.Instant

data class Tournament(
    val tournamentId: Int,
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
}

enum class TournamentTier {
    LEAGUE_CHALLENGE, LEAGUE_CUP, REGIONAL, SPE, INTERNATIONAL, WORLDS;
}

enum class TournamentFormat {
    STANDARD, EXPANDED
}

data class SetFormat(
    val startDate: String,
    val endDate: String,
    val year: Int,
    val startCardSet: String,
    val endCardSet: String,
)

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