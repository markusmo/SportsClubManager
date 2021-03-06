package contract.dto.classes;

import contract.domain.*;
import contract.dto.*;
import contract.dto.mapper.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;

public class LeagueDto
        implements Serializable, ILeagueDto
{
    private int id;
    private String name;
    private String description;
    private ITypeOfSportDto typeOfSport;
    private List<Integer> teamList = new LinkedList<>();
    private List<Integer> competitions = new LinkedList<>();

    public LeagueDto()
    {
    }

    LeagueDto(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<ILeague, LeagueDto> leagues = new HashMap<>();

    public static LeagueDto copy(ILeague league)
    {
        LeagueDto a;

        if (leagues.containsKey(league))
        {
            a = leagues.get(league);
        }
        else
        {
            a = new LeagueDto();

            a.setName(league.getName());
            a.setDescription(league.getDescription());
            ITypeOfSportDto tos = TypeOfSportDto.copy(league.getTypeOfSport());
            a.setTypeOfSport(tos);

            for (ICompetition c : league.getCompetitions())
            {
                a.competitions.add(c.getId());
            }

            for (ITeam d : league.getTeamList())
            {
                a.teamList.add(d.getId());
            }

            leagues.put(league, a);
        }

        return a;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public List<Integer> getTeamList()
    {
        return teamList;
    }

    @Override
    public void setTeamList(List<Integer> teamList)
    {
        this.teamList = teamList;
    }

    @Override
    public List<Integer> getCompetitions()
    {
        return competitions;
    }

    @Override
    public void setCompetitions(List<Integer> competitions)
    {
        this.competitions = competitions;
    }

    @Override
    public ITypeOfSportDto getTypeOfSport()
    {
        return typeOfSport;
    }

    @Override
    public void setTypeOfSport(ITypeOfSportDto typeOfSport)
    {
        this.typeOfSport = typeOfSport;
    }
}
