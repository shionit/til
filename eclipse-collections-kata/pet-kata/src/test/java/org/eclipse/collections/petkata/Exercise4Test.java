/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.petkata;

import java.util.IntSummaryStatistics;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * In this set of tests, wherever you see .stream() replace it with an Eclipse Collections alternative
 */
public class Exercise4Test extends PetDomainForKata
{
    @Test
    public void getAgeStatisticsOfPets()
    {
        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
        MutableIntList petAges = this.people.flatCollect(Person::getPets).collectInt(Pet::getAge);

        MutableIntSet uniqueAges = petAges.toSet();
        // IntSummaryStatistics is a class in JDK 8 - Try and use it with MutableIntList.forEach()
        IntSummaryStatistics stats = new IntSummaryStatistics();
        petAges.forEach(stats::accept);
        // Is a Set<Integer> equal to an IntSet?
        Assert.assertEquals(IntSets.mutable.with(1, 2, 3, 4), uniqueAges);
        // Try to leverage min, max, sum, average from the Eclipse Collections primitive api 
        Assert.assertEquals(stats.getMin(), petAges.min());
        Assert.assertEquals(stats.getMax(), petAges.max());
        Assert.assertEquals(stats.getSum(), petAges.sum());
        Assert.assertEquals(stats.getAverage(), petAges.average(), 0.0);
        Assert.assertEquals(stats.getCount(), petAges.size());

        Assert.assertTrue(petAges.allSatisfy(i -> i > 0));
        Assert.assertFalse(petAges.anySatisfy(i -> i == 0));
        Assert.assertTrue(petAges.noneSatisfy(i -> i < 0));

        // Don't forget to comment this out or delete it when you are done
//        Assert.fail("Refactor to Eclipse Collections");
    }

    @Test
    public void streamsToECRefactor1()
    {
        //find Bob Smith
        Person person =
                this.people.detectWith(Person::named, "Bob Smith");

        //get Bob Smith's pets' names
        String names =
                person.getPets().collect(Pet::getName).makeString(" & ");

        Assert.assertEquals("Dolly & Spot", names);

        // Don't forget to comment this out or delete it when you are done
//        Assert.fail("Refactor to Eclipse Collections");
    }

    @Test
    public void streamsToECRefactor2()
    {
        // Hint: Try to replace the Map<PetType, Long> with a Bag<PetType>
        Bag<PetType> countsStream = this.people.flatCollect(Person::getPets).collect(Pet::getType).toBag();
        Assert.assertEquals(2L, countsStream.occurrencesOf(PetType.CAT));
        Assert.assertEquals(2L, countsStream.occurrencesOf(PetType.DOG));
        Assert.assertEquals(2L, countsStream.occurrencesOf(PetType.HAMSTER));
        Assert.assertEquals(1L, countsStream.occurrencesOf(PetType.SNAKE));
        Assert.assertEquals(1L, countsStream.occurrencesOf(PetType.TURTLE));
        Assert.assertEquals(1L, countsStream.occurrencesOf(PetType.BIRD));

        // Don't forget to comment this out or delete it when you are done
//        Assert.fail("Refactor to Eclipse Collections");
    }

    /**
     * The purpose of this test is to determine the top 3 pet types
     */
    @Test
    public void streamsToECRefactor3()
    {
        Bag<PetType> petTypeBag = this.people.flatCollect(Person::getPets).collect(Pet::getType).toBag();
        ListIterable<ObjectIntPair<PetType>> favoritesStream = petTypeBag.topOccurrences(3);
        Verify.assertSize(3, favoritesStream);
        Verify.assertEquals(2, favoritesStream.detect(op -> op.getOne().equals(PetType.CAT)).getTwo());
        Verify.assertEquals(2, favoritesStream.detect(op -> op.getOne().equals(PetType.DOG)).getTwo());
        Verify.assertEquals(2, favoritesStream.detect(op -> op.getOne().equals(PetType.HAMSTER)).getTwo());

        // Don't forget to comment this out or delete it when you are done
//        Assert.fail("Refactor to Eclipse Collections");
    }
}
