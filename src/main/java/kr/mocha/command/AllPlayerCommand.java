package kr.mocha.command;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import kr.mocha.AllPlayer;

import java.util.LinkedHashMap;

/**
 * Created by mocha on 16. 11. 13.
 */
public class AllPlayerCommand extends Command{
    public Config config = AllPlayer.getInstance().config;
    public Server server = AllPlayer.getInstance().getServer();

    public AllPlayerCommand(){
        super("올플", "플레이어를 제어합니다.", "/올플 <옵션>");
        this.setPermission("allaplyer.cmd");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!sender.hasPermission(this.getPermission()))
            sender.sendMessage(TextFormat.RED+"명령어의 권한이 없습니다.");
        else{
            try{
                switch (args[0]) {
                    case "전체":
                        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) config.getAll();
                        map.forEach((s, o) -> map.put(s, true));
                        config.setAll(map);
                        config.save();
                        AllPlayer.getInstance().update();
                        server.broadcastMessage(
                                TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 모든행위가 제어됩니다.");
                        return true;
                    case "전체풀기":
                        LinkedHashMap<String, Object> map1 = (LinkedHashMap<String, Object>) config.getAll();
                        map1.forEach((s, o) -> map1.put(s, false));
                        config.setAll(map1);
                        config.save();
                        AllPlayer.getInstance().update();
                        server.broadcastMessage(
                                TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 모든행위의 제어가 풀립니다.");
                        return true;
                    case "움직임":
                        config.set("move", !AllPlayer.move);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.move)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 움직임이 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 움직임의 제어가 풀립니다.");
                        return true;
                    case "채팅":
                        config.set("chat", !AllPlayer.chat);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.chat)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 채팅이 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 채팅의 제어가 풀립니다.");
                        return true;
                    case "드랍":
                        config.set("drop", !AllPlayer.drop);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.drop)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 드랍이 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 드랍의 제어가 풀립니다.");
                        return true;
                    case "커맨드":
                        config.set("command", !AllPlayer.command);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.command)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 커맨드가 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 커맨드의 제어가 풀립니다.");
                        return true;
                    case "부수기":
                        config.set("break", !AllPlayer.blockBreak);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.blockBreak)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 부수기가 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 부수기의 제어가 풀립니다.");
                        return true;
                    case "설치":
                        config.set("place", !AllPlayer.blockPlace);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.blockPlace)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 설치가 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 설치의 제어가 풀립니다.");
                        return true;
                    case "싸움":
                        config.set("fight", !AllPlayer.fight);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.fight)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 싸움이 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 싸움의 제어가 풀립니다.");
                        return true;
                    case "폭발":
                        config.set("explode", !AllPlayer.explode);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.explode)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 폭발이 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 폭발의 제어가 풀립니다.");
                        return true;
                    case "활":
                        config.set("bow", !AllPlayer.bow);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.bow)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 활이 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 활의 제어가 풀립니다.");
                        return true;
                    case "만들기":
                        config.set("craft", !AllPlayer.craft);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.craft)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 만들기가 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 만들기의 제어가 풀립니다.");
                        return true;
                    case "인벤토리":
                        config.set("inventory", !AllPlayer.inventory);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.inventory)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 인벤토리 열기가 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 인벤토리 열기의 제어가 풀립니다.");
                        return true;
                    case "데미지":
                        config.set("damage", !AllPlayer.damage);
                        config.save();
                        AllPlayer.getInstance().update();
                        if (AllPlayer.damage)
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 데미지가 제어됩니다.");
                        else
                            server.broadcastMessage(
                                    TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 데미지의 제어가 풀립니다.");
                        return true;
                    case "아이템주기":
                        if(args.length == 2) {
                            try {
                                Item item = Item.fromString(args[1]);
                                AllPlayer.getInstance().getServer().getOnlinePlayers().values().forEach(player -> player.getInventory().addItem(item));
                                server.broadcastMessage(TextFormat.AQUA+"[ 알림 ] "+TextFormat.GRAY+sender.getName()+"(이)가 모두에게 아이템 "+item.getName()+"(을)를 1개 지급하였습니다.");
                            } catch (Exception e) {
                                sender.sendMessage(TextFormat.RED+"지급되지 못했습니다.");
                            }
                        }
                        else if(args.length > 2) {
                            try {
                                Item item = Item.fromString(args[1]);
                                item.setCount(Integer.parseInt(args[2]));
                                AllPlayer.getInstance().getServer().getOnlinePlayers().values().forEach(player -> player.getInventory().addItem(item));
                                server.broadcastMessage(TextFormat.AQUA+"[ 알림 ] "+TextFormat.GRAY+sender.getName()+"(이)가 모두에게 아이템 "+item.getName()+"(을)를 "+item.getCount()+"개 지급하였습니다.");
                            }catch (Exception e) {
                                sender.sendMessage(TextFormat.RED + "지급되지 못했습니다.");
                            }
                        }else sender.sendMessage(TextFormat.RED+this.getUsage());
                        return true;
                    case "디오피" :
                        AllPlayer.getInstance().getServer().getOnlinePlayers().forEach((uuid, player) -> player.setOp(false));
                        server.broadcastMessage(
                                TextFormat.AQUA + "[ 알림 ] " + TextFormat.GRAY + sender.getName() + "님에 의해 모두의 오피가 해제됩니다.");
                        return true;
                    case "도움말":
                        if(args.length == 2){
                            switch (args[1]){
                                case "1":
                                    sender.sendMessage(TextFormat.AQUA+"=== All Player (1/4)===");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 전체 - 모든 행위를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 전체풀기 - 모든 행위의 제어를 해제합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 움직임 - 플레이어의 움직임을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 채팅 - 플레이어의 채팅을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 드랍 - 아이템 드랍을 제어합니다.");
                                    break;
                                case "2":
                                    sender.sendMessage(TextFormat.AQUA+"=== All Player (2/4)===");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 커맨드 - 플레이어의 명령어 입력을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 부수기 - 블럭 부수기를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 설치 - 블럭 설치를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 싸움 - 플레이어의 싸움을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 폭발 - 폭발을 제어합니다.");
                                    break;
                                case "3":
                                    sender.sendMessage(TextFormat.AQUA+"=== All Player (3/4)===");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 활 - 활 쏘기를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 만들기 - 만들기를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 인벤토리 - 플레이어의 인벤토리 열기를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 데미지 - 플레이어가 입는 충격을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 아이템주기 - 모든플레이어에게 아이템을 지급합니다.");
                                    break;
                                case "4":
                                    sender.sendMessage(TextFormat.AQUA+"=== All Player (4/4)===");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 디오피 - 모든 오피를 제거합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 도움말 - 올플 명령어의 도움말을 봅니다.");
                                    sender.sendMessage(TextFormat.AQUA+"");
                                    sender.sendMessage(TextFormat.AQUA+"");
                                    sender.sendMessage(TextFormat.AQUA+"");
                                    break;
                                default:
                                    sender.sendMessage(TextFormat.AQUA+"=== All Player (1/4)===");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 전체 - 모든 행위를 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 전체풀기 - 모든 행위의 제어를 해제합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 움직임 - 플레이어의 움직임을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 채팅 - 플레이어의 채팅을 제어합니다.");
                                    sender.sendMessage(TextFormat.AQUA+"/올플 드랍 - 아이템 드랍을 제어합니다.");
                                    break;
                            }
                        }else {
                            sender.sendMessage(TextFormat.AQUA+"=== All Player (1/4)===");
                            sender.sendMessage(TextFormat.AQUA+"/올플 전체 - 모든 행위를 제어합니다.");
                            sender.sendMessage(TextFormat.AQUA+"/올플 전체풀기 - 모든 행위의 제어를 해제합니다.");
                            sender.sendMessage(TextFormat.AQUA+"/올플 움직임 - 플레이어의 움직임을 제어합니다.");
                            sender.sendMessage(TextFormat.AQUA+"/올플 채팅 - 플레이어의 채팅을 제어합니다.");
                            sender.sendMessage(TextFormat.AQUA+"/올플 드랍 - 아이템 드랍을 제어합니다.");
                        }
                        return true;
                    default:
                        sender.sendMessage(TextFormat.AQUA+"=== All Player (1/3)===");
                        sender.sendMessage(TextFormat.AQUA+"/올플 전체 - 모든 행위를 제어합니다.");
                        sender.sendMessage(TextFormat.AQUA+"/올플 전체풀기 - 모든 행위의 제어를 해제합니다.");
                        sender.sendMessage(TextFormat.AQUA+"/올플 움직임 - 플레이어의 움직임을 제어합니다.");
                        sender.sendMessage(TextFormat.AQUA+"/올플 채팅 - 플레이어의 채팅을 제어합니다.");
                        sender.sendMessage(TextFormat.AQUA+"/올플 드랍 - 아이템 드랍을 제어합니다.");
                        break;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                sender.sendMessage(TextFormat.RED+this.getUsage());
            }
        }
        return false;
    }
}
