package com.footballstats.restapi.controller;

import com.footballstats.restapi.dao.GameEntityDao;
import com.footballstats.restapi.model.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameEntityController {
    private static final String UID = "uid";

    private GameEntityDao dao;

    @Autowired
    public GameEntityController(GameEntityDao dao) {
        this.dao = dao;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody GameEntity gameEntity) {
        return dao.create(gameEntity).toString();
    }

    @GetMapping(value = "/{" + UID + "}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameEntity read(@PathVariable(UID) String uid) {
        return dao.read(uid);
    }

    @DeleteMapping("/{" + UID + "}")
    public void delete(@PathVariable(UID) String uid) {
        dao.delete(uid);
    }
}
