/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.scarsofmirrodin;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.Costs;
import mage.abilities.costs.CostsImpl;
import mage.abilities.costs.common.RemoveCountersSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.cards.CardImpl;
import mage.counters.CounterType;
import mage.target.Target;
import mage.target.common.TargetCreaturePermanent;

import java.util.UUID;
import mage.abilities.costs.mana.GenericManaCost;

/**
 *
 * @author nantuko
 */
public class TrigonOfCorruption extends CardImpl {

    public TrigonOfCorruption (UUID ownerId) {
        super(ownerId, 213, "Trigon of Corruption", Rarity.UNCOMMON, new CardType[]{CardType.ARTIFACT}, "{4}");
        this.expansionSetCode = "SOM";

        this.addAbility(new EntersBattlefieldAbility(new AddCountersSourceEffect(CounterType.CHARGE.createInstance(3)), ""));

        Costs costs = new CostsImpl();
        costs.add(new RemoveCountersSourceCost(CounterType.CHARGE.createInstance()));
        costs.add(new TapSourceCost());
        Effect putCounterEffect = new AddCountersTargetEffect(CounterType.M1M1.createInstance());
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, putCounterEffect, costs);
        ability.addManaCost(new GenericManaCost(2));
        Target target = new TargetCreaturePermanent();
        ability.addTarget(target);
        this.addAbility(ability);

        Ability ability2 = new SimpleActivatedAbility(Zone.BATTLEFIELD, new AddCountersSourceEffect(CounterType.CHARGE.createInstance()), new TapSourceCost());
        ability2.addManaCost(new ManaCostsImpl("{B}{B}"));
        this.addAbility(ability2);
    }

    public TrigonOfCorruption (final TrigonOfCorruption card) {
        super(card);
    }

    @Override
    public TrigonOfCorruption copy() {
        return new TrigonOfCorruption(this);
    }

}
