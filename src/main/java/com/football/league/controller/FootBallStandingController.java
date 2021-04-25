package com.football.league.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.league.dto.TeamStandingDto;
import com.football.league.log.annotation.Trace;
import com.football.league.log.eventtype.LogEventType;
import com.football.league.model.TeamStandingRequest;
import com.football.league.service.TeamStandingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/service/v1/team/standing")
public class FootBallStandingController {

  private final TeamStandingService teamStandingService;

  @Autowired
  public FootBallStandingController(
      TeamStandingService teamStandingService) {
    this.teamStandingService = teamStandingService;
  }

  @GetMapping
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<TeamStandingDto> getStandings(@Valid TeamStandingRequest teamStandingRequest) {
    log.info("Request {}", teamStandingRequest.toString());
    return ResponseEntity.ok(teamStandingService.getTeamStanding(teamStandingRequest));
  }


}
