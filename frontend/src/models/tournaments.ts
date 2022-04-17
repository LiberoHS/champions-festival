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

export interface SetFormat {
    startDate?: string;
    endDate?: string;
    year: number;
    startCardSet: string;
    endCardSet: string;
}

export enum TournamentFormat {
    STANDARD = "Standard",
    EXPANDED = "Expanded"
}

export interface Tournament {
    tournamentId: number;
    tournamentName: string;
    date: string;
    region: string;
    attendance: number;
    tournamentTier: TournamentTier;
    setFormat: SetFormat;
    tournamentFormat: TournamentFormat;
    standings: PlayerStandings[];
}