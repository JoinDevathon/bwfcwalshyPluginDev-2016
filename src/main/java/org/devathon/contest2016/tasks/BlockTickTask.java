package org.devathon.contest2016.tasks;

import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.Handler;

public class BlockTickTask implements Runnable {

    private Handler handler;
    public BlockTickTask(DevathonPlugin plugin){
        this.handler = plugin.getHandler();
    }

    @Override
    public void run() {
        handler.getBlocks().keySet().forEach(location -> handler.getBlocks().get(location).tick(location));
    }
}
