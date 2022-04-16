import {Tournament, TournamentTier} from "./models/tournaments";

export const EXAMPLE_TOURNAMENT: Tournament = {
    tournamentId: 1,
    tournamentName: "Sydney League Cup",
    date: "01/01/2022",
    region: "NSW",
    attendance: 123,
    tournamentTier: TournamentTier.LEAGUE_CUP,
    quarter: 1,
    format: {
        start: "SWS",
        end: "BRS",
        year: 2022
    },
    standings: []
}