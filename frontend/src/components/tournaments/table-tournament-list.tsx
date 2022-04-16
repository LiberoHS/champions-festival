import React, {FC} from 'react';
import {Table, TableBody, TableCell, TableHeader, TableRow} from "grommet";
import {Tournament} from "../../models/tournaments";

interface TableProps {
    tournaments: Tournament[]
}

export const TournamentListTable: FC<TableProps> = ({ tournaments }) => {
    const columns = [
        {
            field: 'date',
            text: 'Date'
        },
        {
            field: 'name',
            text: 'Name'
        },
        {
            field: 'region',
            text: 'Region'
        },
        {
            field: 'type',
            text: 'Type'
        },
        {
            field: 'attendance',
            text: 'Attendance'
        },
    ]

    const headerRows = () => {
        return columns.map((key) => {
            return (
                <TableCell border>
                    {key.text}
                </TableCell>
            )
        })
    };

    const bodyRows = () => {
        return tournaments.map((event) => {
            return (
                <TableRow>
                    <TableCell scope="row" border>
                        {event.date}
                    </TableCell>
                    <TableCell scope="row" border>
                        {event.tournamentName}
                    </TableCell>
                    <TableCell scope="row" border>
                        {event.region}
                    </TableCell>
                    <TableCell scope="row" border>
                        {event.tournamentTier}
                    </TableCell>
                    <TableCell scope="row" border>
                        {event.attendance}
                    </TableCell>
                </TableRow>
            )
        })
    }

    return (
        <>
            <Table>
                <TableHeader>
                    {headerRows()}
                </TableHeader>
                <TableBody>
                    {bodyRows()}
                </TableBody>
            </Table>
        </>
    )
}