package com.azortis.protocolvanish.placeholderexpansion;

import com.azortis.protocolvanish.ProtocolVanish;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ProtocolVanishPlaceholderExpansion extends PlaceholderExpansion {

    private ProtocolVanish plugin;

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().isPluginEnabled("ProtocolVanish");
    }

    @Override
    public boolean register(){
        if(!canRegister())return false;
        plugin = (ProtocolVanish) Bukkit.getPluginManager().getPlugin("ProtocolVanish");
        if(plugin == null) return false;
        return super.register();
    }

    public String getIdentifier() {
        return "protocolvanish";
    }

    public String getAuthor() {
        return "YourPalJake";
    }

    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getRequiredPlugin(){
        return "ProtocolVanish";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){
        if(identifier.equalsIgnoreCase("vanished_player_count"))return Integer.toString(plugin.getVisibilityManager().getVanishedPlayers().size());
        if(identifier.equalsIgnoreCase("player_is_vanished")){
            if(player != null){
                return plugin.getVisibilityManager().isVanished(player.getUniqueId()) ? "true" : "false";
            }
        }
        return null;
    }

}
