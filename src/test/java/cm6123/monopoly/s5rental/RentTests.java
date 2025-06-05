package com.cm6123.monopoly.s5rental;

import cm6123.game.Player;
import com.cm6123.monopoly.game.Property;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to verify rent transactions between players.
 */
public class RentTests {

    @Test
    public void testRentIsTransferredFromTenantToOwner() {
        Player owner = new Player("Owner", Color.BLUE);
        Player tenant = new Player("Tenant", Color.RED);
        Property property = new Property("Property", 4, 300);
        property.setOwner(owner);

        int rent = property.getCost() / 10;
        int tenantStart = tenant.getBalance();
        int ownerStart = owner.getBalance();

        tenant.payRent(owner, rent);

        assertEquals(tenantStart - rent, tenant.getBalance());
        assertEquals(ownerStart + rent, owner.getBalance());
    }

    @Test
    public void testNoRentIfOwnerIsSelf() {
        Player player = new Player("OwnerPlayer", Color.GREEN);
        Property property = new Property("Owned", 8, 200);
        property.setOwner(player);

        int rent = property.getCost() / 10;
        int initialBalance = player.getBalance();

        player.payRent(player, rent);
        assertEquals(initialBalance, player.getBalance());
    }
}
