package kr.mocha;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.entity.*;
import cn.nukkit.event.inventory.CraftItemEvent;
import cn.nukkit.event.inventory.InventoryOpenEvent;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.player.PlayerDropItemEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import kr.mocha.command.AllPlayerCommand;

import java.util.LinkedHashMap;

/**
 * Created by mocha on 16. 11. 13.
 */
public class AllPlayer extends PluginBase implements Listener{
    public static AllPlayer instance;
    public Config config;

    public static boolean move;
    public static boolean chat;
    public static boolean drop;
    public static boolean command;
    public static boolean blockBreak;
    public static boolean blockPlace;
    public static boolean fight;
    public static boolean explode;
    public static boolean bow;
    public static boolean craft;
    public static boolean inventory;
    public static boolean damage;

    @Override
    public void onEnable() {
        instance = this;
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("move", false);
        map.put("chat", false);
        map.put("drop", false);
        map.put("command", false);
        map.put("break", false);
        map.put("place", false);
        map.put("fight", false);
        map.put("explode", false);
        map.put("bow", false);
        map.put("craft", false);
        map.put("inventory", false);
        map.put("damage", false);
        getDataFolder().mkdirs();
        config = new Config(getDataFolder()+"/config.yml", Config.YAML, map);
        update();
        this.getServer().getCommandMap().register("올플", new AllPlayerCommand());
	    this.getServer().getPluginManager().registerEvents(this, this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        config.save();
        super.onDisable();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(move&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("움직임이 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onChat(PlayerChatEvent event){
        if(chat&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("채팅이 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        if(drop&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("아이템 드랍이 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){
        if(command&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("명령어 입력이 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(blockBreak&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("블럭 부수기가 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if(blockPlace&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("블럭 설치가 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onPVP(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player&& event.getDamager() instanceof  Player){
            if(fight&&!((Player)event.getDamager()).isOp()){
                event.setCancelled();
                ((Player)event.getEntity()).sendMessage("싸움이 제어당하고 있습니다.");
            }
        }
    }
    @EventHandler
    public void onExplode(ExplosionPrimeEvent event){
        if(explode)event.setCancelled();
    }
    @EventHandler
    public void onBow(EntityShootBowEvent event){
        if(event.getEntity() instanceof Player){
            if(bow&&!((Player)event.getEntity()).isOp()){
                event.setCancelled();
                ((Player)event.getEntity()).sendMessage("활쏘기가 제어당하고 있습니다.");
            }
        }
    }
    @EventHandler
    public void onCraft(CraftItemEvent event){
        if(craft&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("만들기가 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void openInventory(InventoryOpenEvent event){
        if(inventory&&!event.getPlayer().isOp()){
            event.setCancelled();
            event.getPlayer().sendMessage("인벤토리 열기가 제어당하고 있습니다.");
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            if(damage) event.setCancelled();
        }
    }

    public static AllPlayer getInstance(){
        return instance;
    }

    public void update(){
        move = config.getBoolean("move");
        chat = config.getBoolean("chat");
        drop = config.getBoolean("drop");
        command = config.getBoolean("command");
        blockBreak = config.getBoolean("break");
        blockPlace = config.getBoolean("place");
        fight = config.getBoolean("fight");
        explode = config.getBoolean("explode");
        bow = config.getBoolean("bow");
        craft = config.getBoolean("craft");
        inventory = config.getBoolean("inventory");
        damage = config.getBoolean("damage");
    }

}
