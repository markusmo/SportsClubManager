/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.Competition;
import sportsclubmanager.dto.contract.ICompetition;
import sportsclubmanager.dto.controller.contract.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
 class CompetitionController
        implements IController<ICompetition>
{
    private static CompetitionController controller;

     CompetitionController()
    {
    }

    public static IController<ICompetition> getInstance()
    {
        if (controller == null)
        {
            controller = new CompetitionController();
        }

        return controller;
    }

    public sportsclubmanager.domain.contract.ICompetition getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ICompetition a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICompetition.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public ICompetition getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ICompetition a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICompetition.class))
        {
            if (a.getId() == id)
            {
                return Competition.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ICompetition> getAll()
    {
        List<ICompetition> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ICompetition a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICompetition.class))
        {
            result.add(Competition.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(ICompetition value)
    {
        try
        {
            sportsclubmanager.domain.classes.Competition competition = createDomain(value);

            return DomainFacade.set(competition);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(CompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ICompetition value)
    {
        try
        {
            sportsclubmanager.domain.classes.Competition competition = createDomain(value);

            DomainFacade.delete(competition);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private sportsclubmanager.domain.classes.Competition createDomain(ICompetition value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Competition competition = new sportsclubmanager.domain.classes.Competition(value.getId());

        competition.setDateFrom(value.getDateFrom());
        competition.setDateTo(value.getDateTo());
        competition.setPayment(value.getPayment());

        List< sportsclubmanager.domain.contract.IMatch> matchList = new LinkedList<>();
        List< sportsclubmanager.domain.contract.ITeam> teamList = new LinkedList<>();

        for (int i : value.getMatchList())
        {
            matchList.add(new MatchController().getDomainById(i));
        }

        for (int i : value.getTeamList())
        {
            teamList.add(new TeamController().getDomainById(i));
        }

        competition.setMatchList(matchList);

        competition.setTeamList(teamList);

        return competition;
    }
}