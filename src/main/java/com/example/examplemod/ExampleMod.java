package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.play.client.CChatMessagePacket;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.stream.Collectors;

@Mod("examplemod")
@Mod.EventBusSubscriber(modid = "examplemod", bus = Bus.FORGE, value = Dist.CLIENT)
public class ExampleMod
{

    @SubscribeEvent
    public static void onPlayerJoin(ClientPlayerNetworkEvent.LoggedInEvent event) {
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if (player != null && player.connection != null) {
            player.connection.send(new CChatMessagePacket("/sw"));
            player.connection.send(new CChatMessagePacket("/v"));
        }
    }
}