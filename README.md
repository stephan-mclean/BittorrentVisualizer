##CA326 Third year project.
BitTorrent Visualiser (BTV) is a BitTorrent client, implemented in Java, which gives a visual representation of BitTorrent downloads in near real time.

### Requirements
Java 7
JavaFX 2.0

### To run the project
#### OSX
javac -cp ".:/Library/Java/JavaVirtualMachines/jdk1.7.0_45.jdk/Contents/Home/jre/lib/jfxrt.jar" btv/client/gui/BTVUI.java

java -cp ".:/Library/Java/JavaVirtualMachines/jdk1.7.0_45.jdk/Contents/Home/jre/lib/jfxrt.jar" btv/client/gui/BTVUI


###Currently: 
Debugging, improving performance. Visualisation window is a bit untidy(some peers off screen etc).

### Screenshot of Visualisation.
![alt tag](Screen Shot 2014-03-15 at 17.10.44.png)

###Progress:
- Can parse metainfo file.
- Successfully contacts tracker and parses response
- Connects to peers.
- Handshakes with peers.
- Requests pieces from peers.
- Parses peer messages.
- Writes downloaded pieces to disk.
- Basic CLI implemented which can download multiple torrents. (very rough.)

###TODO:
- ~~Need to deal with all possibilities in the meta-info file e.g multiple file torrents.~~ (Done - 3rd March 2014)
- Make class Tracker a thread so we can send stats and receive updates at a regular interval.
- Deal with UDP Trackers
- ~~Model Messages as classes.~~
- ~~Make class Peer a thread.~~
- Come up with and implement a file caching algorithm.
- ~~Implement an end game strategy~~ (Improve later.)
- ~~Implement a piece choosing algorithm.~~ (Need to improve)
- Refinement in all classes, a lot of the current code is very untidy and contains some bad practices (exceptions, preamble missing).
- ~~Group classes in packages.~~

###More TODO(Further away):
- ~~Event handling.~~
- ~~GUI~~

### Issues
#### 25th February 2014
- BDecoding fails on some tracker responses.
- Download sticks on last piece
- Occasional out of memory errors in class Peer
- ~~Very high CPU usage on large torrents (need better thread management)~~

#### 3rd March 2014
- ~~Splitting the temporary download file into proper files is slow. We are also using a temporary file for single file torrents which is unnecessary, we will remove this in the future.~~ Fixed by using Java's nio classes rather than streams.

#### 10th March 2014
- ~~Some concurrency issues when downloading multiple torrents.~~ Fixed by using EventRelayer class

#### 17th March 2014
- Visualisation stutters when opened if the download is already in progress.
- If torrent is removed we need to close Visualisation window

### Authors
Stephan McLean & Kevin Sweeney
