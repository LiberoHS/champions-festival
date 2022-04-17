import {Tournament, TournamentFormat, TournamentTier} from "./models/tournaments";

export const EXAMPLE_TOURNAMENT: Tournament = {
    tournamentId: 1,
    tournamentName: "Sydney League Cup",
    date: "01/01/2022",
    region: "NSW",
    attendance: 123,
    tournamentTier: TournamentTier.LEAGUE_CUP,
    setFormat: {
        startCardSet: "SWS",
        endCardSet: "BRS",
        year: 2022
    },
    tournamentFormat: TournamentFormat.STANDARD,
    standings: []
}