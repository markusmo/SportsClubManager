/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.IChangeCompetitionTeam;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author EnjoX
 */
public class ChangeCompetitionTeam
        implements IChangeCompetitionTeam
{
    private static IChangeCompetitionTeam INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    private ChangeCompetitionTeam()
    {
    }

    public static IChangeCompetitionTeam getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ChangeCompetitionTeam();
        }
        return INSTANCE;
    }

    @Override
    public List<ICompetitionDto> getCompetition()
    {
        try
        {
            return dtoFactory.getCompetitionMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> Teams)
    {
        List<IClubTeamDto> clubTeamList = new ArrayList<>();

        try
        {
            for (Integer teamId : Teams)
            {
                clubTeamList.add(dtoFactory.getClubTeamMapper().getById(teamId));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clubTeamList;
    }

    @Override
    public void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
    {
        List<Integer> teamList = competition.getTeamList();

        for (Integer team : teamList)
        {
            if (team == oldTeam.getId())
            {
                team = newTeam.getId();
            }
        }
        try
        {
            dtoFactory.getCompetitionMapper().set(competition);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IClubTeamDto> getClubTeams()
    {
        try
        {
            return dtoFactory.getClubTeamMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IClubTeamDto getCompetitionTeam(IClubTeamDto team)
    {
        //Sry han kA meh was i do tu muss ^^
        return team;
    }

    @Override
    public List<IPlayerDto> getPlayers(List<Integer> players)
    {
        List<IPlayerDto> playerList = new ArrayList<>();

        try
        {
            for (Integer player : players)
            {
                playerList.add(dtoFactory.getPlayerMapper().getById(player));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playerList;
    }
}
