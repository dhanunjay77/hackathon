package com.hackathon.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ACTIVITY')")
public class ActivityController {



}
