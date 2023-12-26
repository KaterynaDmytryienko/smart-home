package smart.home.event;

public enum Even_Types {
    //separate Hungry_animal and Hungry_person
    // (for animal PetFeeder handles event ,for person personHandler)


    //should order everything in GROUPS:1)"sport events",
    // 2)"device usage(first the ones only adults can resolve then the ones children can)"
    //3)animal events

   // New event ideas: SPILLED_SOMETHING,WORKOUT,SKI,CYCLE,COOK,DRIVE,CLEAN
    FLOOD,DEVICE_BREAKAGE, HEAT, BABY_SCREAM, ENTER_ROOM,EXIT_ROOM,
    HUNGRY, THIRSTY, PLAY
}
