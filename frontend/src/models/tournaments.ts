import DateTimeFormat = Intl.DateTimeFormat;
import {PlayerStandings} from "./standings";

export enum TournamentTier {
    LEAGUE_CHALLENGE = "League Challenge",
    LEAGUE_CUP = "League Cup",
    REGIONAL = "Regional",
    SPE = "Special Event",
    INTERNATIONAL = "International",
    WORLDS = "Worlds"
}

export interface TournamentFormat {
    start: string;
    end: string;
    year: number;
}

export interface Tournament {
    tournamentId: number;
    tournamentName: string;
    date: string;
    region: string;
    attendance: number;
    tournamentTier: TournamentTier;
    quarter: number;
    format: TournamentFormat;
    standings: PlayerStandings[];
}