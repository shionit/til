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

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class Exercise3Test extends PetDomainForKata
{
    @Test
    public void getCountsByPetType()
    {
        MutableList<PetType> petTypes = this.people.flatCollect(Person::getPets).collect(Pet::getType);
        Bag<PetType> counts = petTypes.toBag();

        Assert.assertEquals(2, counts.occurrencesOf(PetType.CAT));
        Assert.assertEquals(2, counts.occurrencesOf(PetType.DOG));
        Assert.assertEquals(2, counts.occurrencesOf(PetType.HAMSTER));
        Assert.assertEquals(1, counts.occurrencesOf(PetType.SNAKE));
        Assert.assertEquals(1, counts.occurrencesOf(PetType.TURTLE));
        Assert.assertEquals(1, counts.occurrencesOf(PetType.BIRD));
    }

    @Test
    public void getPeopleByLastName()
    {
        Multimap<String, Person> byLastNameMultimap = this.people.groupBy(Person::getLastName);

        Verify.assertIterableSize(3, byLastNameMultimap.get("Smith"));
    }

    @Test
    public void getPeopleByTheirPets()
    {
        MutableSetMultimap<PetType, Person> peopleByPetType = UnifiedSetMultimap.newMultimap();

        this.people.each(person ->
                person.getPets().each(pet -> {
                    peopleByPetType.put(pet.getType(), person);
                })
        );

        Verify.assertIterableSize(2, peopleByPetType.get(PetType.CAT));
        Verify.assertIterableSize(2, peopleByPetType.get(PetType.DOG));
        Verify.assertIterableSize(1, peopleByPetType.get(PetType.HAMSTER));
        Verify.assertIterableSize(1, peopleByPetType.get(PetType.TURTLE));
        Verify.assertIterableSize(1, peopleByPetType.get(PetType.BIRD));
        Verify.assertIterableSize(1, peopleByPetType.get(PetType.SNAKE));
    }
}
