/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
    let totalRooms = rooms.length;
    let visitedRooms = new Map();
    let queue = [];
    queue.push(0);
    visitedRooms.set(0,true);
    while(queue.length>0){
        let cur = queue.pop();
        for(let nextRoom of rooms[cur]){
            if(visitedRooms.has(nextRoom)){
                continue;
            }else{
                visitedRooms.set(nextRoom,true);
                queue.push(nextRoom);
            }
        }
    }
    // console.log(visitedRooms);
    for(let i=0;i<totalRooms;i++){
        if((visitedRooms.has(i)) == false){
            // console.log(i);
            return false;
        }
    }
    return true;
};