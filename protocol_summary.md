# RSPROT Protocol Summary

This document contains all the protocols extracted from the rsprot-master repository for OSRS (Old School RuneScape) protocol versions 221-231.

## Protocol Structure Overview

The rsprot library contains protocol definitions for multiple OSRS versions (221-231), with each version having:
- **Game Server Protocols** (outgoing from server to client)
- **Game Client Protocols** (incoming from client to server)
- **Login Protocols** (authentication)
- **JS5 Protocols** (cache/update system)

## Core Protocol Interfaces

### Base Protocol Interface
```kotlin
public sealed interface Prot {
    public val opcode: Int
    public val size: Int
    
    public companion object {
        public const val VAR_BYTE: Int = -1
        public const val VAR_SHORT: Int = -2
    }
}
```

### Server Protocol Interface
```kotlin
public interface ServerProt : Prot
```

### Client Protocol Interface
```kotlin
public interface ClientProt : Prot
```

## OSRS 231 Protocol Definitions

### Game Server Protocols (Outgoing)

| Opcode | Protocol Name | Size | Description |
|--------|---------------|------|-------------|
| 0 | VARP_SMALL | 3 | Small variable player |
| 1 | CLANCHANNEL_FULL | VAR_SHORT | Full clan channel update |
| 2 | SOUND_AREA | 7 | Area sound effect |
| 3 | VARCLAN_ENABLE | 0 | Enable clan system |
| 4 | UPDATE_RUNWEIGHT | 2 | Update run weight |
| 5 | REFLECTION_CHECKER | VAR_SHORT | Reflection check |
| 6 | CLANSETTINGS_FULL | VAR_SHORT | Full clan settings |
| 7 | LOC_ANIM | 4 | Location animation |
| 8 | CAM_MOVETO_CYCLES | 8 | Camera move with cycles |
| 9 | TRIGGER_ONDIALOGABORT | 0 | Trigger dialog abort |
| 10 | UPDATE_ZONE_FULL_FOLLOWS | 3 | Full zone update follows |
| 11 | UPDATE_ZONE_PARTIAL_FOLLOWS | 3 | Partial zone update follows |
| 12 | NPC_INFO_SMALL_V5 | VAR_SHORT | Small NPC info |
| 13 | VARP_LARGE | 6 | Large variable player |
| 14 | VARP_RESET | 0 | Reset variable player |
| 15 | MESSAGE_FRIENDCHANNEL | VAR_BYTE | Friend channel message |
| 16 | UPDATE_INV_STOPTRANSMIT | 2 | Stop inventory transmission |
| 17 | CAM_SMOOTHRESET | 4 | Smooth camera reset |
| 18 | CLANCHANNEL_DELTA | VAR_SHORT | Clan channel delta |
| 19 | CHAT_FILTER_SETTINGS | 2 | Chat filter settings |
| 20 | LOC_ADD_CHANGE_V2 | VAR_SHORT | Location add/change |
| 21 | HIDENPCOPS | 1 | Hide NPC options |
| 22 | OBJ_COUNT | 11 | Object count |
| 23 | REBUILD_NORMAL | VAR_SHORT | Normal rebuild |
| 24 | IF_MOVESUB | 8 | Interface move sub |
| 25 | UPDATE_REBOOT_TIMER | 2 | Update reboot timer |
| 26 | LOC_MERGE | 14 | Location merge |
| 27 | UPDATE_FRIENDLIST | VAR_SHORT | Update friend list |
| 28 | REBUILD_REGION | VAR_SHORT | Region rebuild |
| 29 | MESSAGE_CLANCHANNEL_SYSTEM | VAR_BYTE | Clan channel system message |
| 30 | MESSAGE_CLANCHANNEL | VAR_BYTE | Clan channel message |
| 31 | MESSAGE_PRIVATE | VAR_SHORT | Private message |
| 32 | OBJ_ENABLED_OPS | 4 | Object enabled operations |
| 33 | HISCORE_REPLY | VAR_SHORT | High score reply |
| 34 | IF_SETPLAYERMODEL_BASECOLOUR | 6 | Set player model base color |
| 35 | UPDATE_INV_PARTIAL | VAR_SHORT | Partial inventory update |
| 36 | RUNCLIENTSCRIPT | VAR_SHORT | Run client script |
| 37 | MESSAGE_PRIVATE_ECHO | VAR_SHORT | Private message echo |
| 38 | UPDATE_STAT_V2 | 7 | Update stat v2 |
| 39 | CAM_LOOKAT_EASED_COORD | 7 | Camera look at eased coordinate |
| 40 | SERVER_TICK_END | 0 | Server tick end |
| 41 | IF_SETNPCHEAD | 6 | Set NPC head |
| 42 | IF_RESYNC_V1 | VAR_SHORT | Interface resync v1 |
| 43 | IF_SETTEXT | VAR_SHORT | Set interface text |
| 44 | NPC_SPOTANIM_SPECIFIC | 9 | NPC spot animation specific |
| 45 | NPC_ANIM_SPECIFIC | 5 | NPC animation specific |
| 46 | CHAT_FILTER_SETTINGS_PRIVATECHAT | 1 | Chat filter settings private chat |
| 47 | REBUILD_WORLDENTITY_V2 | VAR_SHORT | Rebuild world entity v2 |
| 48 | LOGOUT_TRANSFER | VAR_BYTE | Logout transfer |
| 49 | IF_SETANGLE | 10 | Set interface angle |
| 50 | IF_SETOBJECT | 10 | Set interface object |
| 51 | MINIMAP_TOGGLE | 1 | Minimap toggle |
| 52 | CAM_SHAKE | 4 | Camera shake |
| 53 | IF_SETNPCHEAD_ACTIVE | 6 | Set NPC head active |
| 54 | IF_SETSCROLLPOS | 6 | Set interface scroll position |
| 55 | UPDATE_ZONE_PARTIAL_ENCLOSED | VAR_SHORT | Partial zone update enclosed |
| 56 | SYNTH_SOUND | 5 | Synthesized sound |
| 57 | SET_INTERACTION_MODE | 4 | Set interaction mode |
| 58 | IF_SETPLAYERHEAD | 4 | Set player head |
| 59 | HINT_ARROW | 6 | Hint arrow |
| 60 | IF_SETANIM | 6 | Set interface animation |
| 61 | IF_SETCOLOUR | 6 | Set interface color |
| 62 | URL_OPEN | VAR_SHORT | Open URL |
| 63 | UPDATE_UID192 | 28 | Update UID192 |
| 64 | CAM_RESET | 0 | Camera reset |
| 65 | HIDEOBJOPS | 1 | Hide object options |
| 66 | CAM_LOOKAT | 6 | Camera look at |
| 67 | MIDI_JINGLE | 5 | MIDI jingle |
| 68 | FRIENDLIST_LOADED | 0 | Friend list loaded |
| 69 | SEND_PING | 8 | Send ping |
| 70 | IF_SETMODEL | 6 | Set interface model |
| 71 | SITE_SETTINGS | VAR_BYTE | Site settings |
| 72 | SET_HEATMAP_ENABLED | 1 | Set heatmap enabled |
| 73 | OBJ_ADD | 14 | Add object |
| 74 | MIDI_SWAP | 8 | MIDI swap |
| 75 | SET_PLAYER_OP | VAR_BYTE | Set player option |
| 76 | SET_NPC_UPDATE_ORIGIN | 2 | Set NPC update origin |
| 77 | NPC_INFO_LARGE_V5 | VAR_SHORT | Large NPC info |
| 78 | CAM_MOVETO | 6 | Camera move to |
| 79 | IF_SETEVENTS_V1 | 12 | Set interface events v1 |
| 80 | IF_OPENTOP | 2 | Open interface top |
| 81 | IF_SETHIDE | 5 | Set interface hide |
| 82 | UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER | VAR_BYTE | Update friend chat channel single user |
| 83 | IF_SETPLAYERMODEL_BODYTYPE | 5 | Set player model body type |
| 84 | IF_SETPLAYERMODEL_OBJ | 8 | Set player model object |
| 85 | IF_SETROTATESPEED | 8 | Set interface rotate speed |
| 86 | VARCLAN_DISABLE | 0 | Disable clan system |
| 87 | IF_OPENSUB | 7 | Open interface sub |
| 88 | CLANSETTINGS_DELTA | VAR_SHORT | Clan settings delta |
| 89 | MIDI_SONG_STOP | 4 | MIDI song stop |
| 90 | IF_CLOSESUB | 4 | Close interface sub |
| 91 | CAM_TARGET_V3 | 5 | Camera target v3 |
| 92 | PLAYER_ANIM_SPECIFIC | 3 | Player animation specific |
| 93 | UPDATE_INV_FULL | VAR_SHORT | Full inventory update |
| 94 | SET_MAP_FLAG | 2 | Set map flag |
| 95 | MESSAGE_GAME | VAR_BYTE | Game message |
| 96 | LOGOUT | 0 | Logout |
| 97 | OCULUS_SYNC | 4 | Oculus sync |
| 98 | UPDATE_RUNENERGY | 2 | Update run energy |
| 99 | CAM_ROTATEBY | 7 | Camera rotate by |
| 100 | VARP_SYNC | 0 | Variable player sync |
| 101 | UPDATE_IGNORELIST | VAR_SHORT | Update ignore list |
| 102 | MAP_ANIM | 6 | Map animation |
| 103 | CAM_ROTATETO | 7 | Camera rotate to |
| 104 | CAM_MOVETO_ARC | 10 | Camera move to arc |
| 105 | IF_SETPLAYERMODEL_SELF | 5 | Set player model self |
| 106 | MIDI_SONG_V2 | 10 | MIDI song v2 |
| 107 | RESET_ANIMS | 0 | Reset animations |
| 108 | IF_SETPOSITION | 8 | Set interface position |
| 109 | OBJ_DEL | 7 | Delete object |
| 110 | PLAYER_SPOTANIM_SPECIFIC | 9 | Player spot animation specific |
| 111 | LOGOUT_WITHREASON | 1 | Logout with reason |
| 112 | NPC_HEADICON_SPECIFIC | 9 | NPC head icon specific |
| 113 | VARCLAN | VAR_BYTE | Clan variable |
| 114 | PLAYER_INFO | VAR_SHORT | Player info |
| 115 | CAM_MODE | 1 | Camera mode |
| 116 | MAP_PROJANIM_V1 | 20 | Map projectile animation v1 |
| 117 | IF_CLEARINV | 4 | Clear interface inventory |
| 118 | MAP_ANIM_SPECIFIC | 8 | Map animation specific |
| 119 | UPDATE_STOCKMARKET_SLOT | 20 | Update stock market slot |
| 120 | LOC_ANIM_SPECIFIC | 6 | Location animation specific |
| 121 | UPDATE_FRIENDCHAT_CHANNEL_FULL_V2 | VAR_SHORT | Update friend chat channel full v2 |
| 122 | MIDI_SONG_WITHSECONDARY | 12 | MIDI song with secondary |
| 123 | UNKNOWN_STRING | VAR_BYTE | Unknown string |
| 124 | PROJANIM_SPECIFIC_V3 | 22 | Projectile animation specific v3 |
| 125 | UPDATE_TRADINGPOST | VAR_SHORT | Update trading post |
| 126 | LOC_DEL | 2 | Delete location |
| 127 | HIDELOCOPS | 1 | Hide location options |
| 128 | RESET_INTERACTION_MODE | 2 | Reset interaction mode |
| 129 | OBJ_UNCUSTOMISE | 7 | Uncustomize object |
| 130 | IF_SETEVENTS_V2 | 16 | Set interface events v2 |
| 131 | PACKET_GROUP_START | 2 | Packet group start |
| 132 | IF_RESYNC_V2 | VAR_SHORT | Interface resync v2 |
| 133 | OBJ_CUSTOMISE | 17 | Customize object |
| 134 | PROJANIM_SPECIFIC_V4 | 27 | Projectile animation specific v4 |
| 135 | SET_ACTIVE_WORLD_V2 | 3 | Set active world v2 |
| 136 | WORLDENTITY_INFO_V5 | VAR_SHORT | World entity info v5 |

### Game Client Protocols (Incoming)

| Opcode | Protocol Name | Size | Description |
|--------|---------------|------|-------------|
| 0 | OPLOCT | 15 | Op location with target |
| 1 | OPPLAYER6 | 3 | Op player 6 |
| 2 | SEND_PING_REPLY | 10 | Send ping reply |
| 3 | FRIENDLIST_DEL | VAR_BYTE | Delete from friend list |
| 4 | AFFINEDCLANSETTINGS_SETMUTED_FROMCHANNEL | VAR_BYTE | Set muted from channel |
| 5 | OPNPC5 | 3 | Op NPC 5 |
| 6 | OPOBJ3 | 7 | Op object 3 |
| 7 | IF_BUTTOND | 16 | Interface button drag |
| 8 | FRIENDCHAT_SETRANK | VAR_BYTE | Set friend chat rank |
| 9 | IF_RUNSCRIPT | VAR_SHORT | Interface run script |
| 10 | OPPLAYER1 | 3 | Op player 1 |
| 11 | OPNPCU | 11 | Op NPC with target |
| 12 | OPPLAYER7 | 3 | Op player 7 |
| 13 | EVENT_MOUSE_CLICK | 6 | Mouse click event |
| 14 | OPNPC3 | 3 | Op NPC 3 |
| 15 | MESSAGE_PUBLIC | VAR_BYTE | Public message |
| 16 | UPDATE_PLAYER_MODEL_V2 | 26 | Update player model v2 |
| 17 | IF_BUTTON2 | 8 | Interface button 2 |
| 18 | IF_BUTTON3 | 8 | Interface button 3 |
| 19 | OPOBJ5 | 7 | Op object 5 |
| 20 | RSEVEN_STATUS | 1 | RS7 status |
| 21 | IF_CRMVIEW_CLICK | 22 | Interface CRM view click |
| 22 | CLANCHANNEL_KICKUSER | VAR_BYTE | Kick user from clan channel |
| 23 | IF_BUTTON8 | 8 | Interface button 8 |
| 24 | IF_BUTTON10 | 8 | Interface button 10 |
| 25 | CLANCHANNEL_FULL_REQUEST | 1 | Clan channel full request |
| 26 | IF_SUBOP | 10 | Interface sub operation |
| 27 | OPNPCT | 11 | Op NPC with target |
| 28 | OPLOC5 | 7 | Op location 5 |
| 29 | OPLOC3 | 7 | Op location 3 |
| 30 | EVENT_CAMERA_POSITION | 4 | Camera position event |
| 31 | SOUND_JINGLEEND | 4 | Sound jingle end |
| 32 | SET_HEADING | 1 | Set heading |
| 33 | MEMBERSHIP_PROMOTION_ELIGIBILITY | 2 | Membership promotion eligibility |
| 34 | OPLOC2 | 7 | Op location 2 |
| 35 | BUG_REPORT | VAR_SHORT | Bug report |
| 36 | SEND_SNAPSHOT | VAR_BYTE | Send snapshot |
| 37 | OPNPC1 | 3 | Op NPC 1 |
| 38 | RESUME_P_NAMEDIALOG | VAR_BYTE | Resume named dialog |
| 39 | OPNPC4 | 3 | Op NPC 4 |
| 40 | OPLOC4 | 7 | Op location 4 |
| 41 | OPPLAYER3 | 3 | Op player 3 |
| 42 | EVENT_NATIVE_MOUSE_CLICK | 7 | Native mouse click event |
| 43 | CLICKWORLDMAP | 4 | Click world map |
| 44 | WINDOW_STATUS | 5 | Window status |
| 45 | OPLOC6 | 2 | Op location 6 |
| 46 | CLANSETTINGS_FULL_REQUEST | 1 | Clan settings full request |
| 47 | AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL | VAR_BYTE | Add banned from channel |
| 48 | OPPLAYER5 | 3 | Op player 5 |
| 49 | MAP_BUILD_COMPLETE | 0 | Map build complete |
| 50 | MESSAGE_PRIVATE | VAR_SHORT | Private message |
| 51 | IF_BUTTONT | 16 | Interface button target |
| 52 | OPPLAYERU | 11 | Op player with target |
| 53 | IF_BUTTON | 4 | Interface button |
| 54 | CLOSE_MODAL | 0 | Close modal |
| 55 | HISCORE_REQUEST | VAR_BYTE | High score request |
| 56 | EVENT_NATIVE_MOUSE_MOVE | VAR_BYTE | Native mouse move event |
| 57 | RESUME_P_COUNTDIALOG | 4 | Resume count dialog |
| 58 | IDLE | 0 | Idle |
| 59 | OPOBJU | 15 | Op object with target |
| 60 | OPPLAYER2 | 3 | Op player 2 |
| 61 | RESUME_P_OBJDIALOG | 2 | Resume object dialog |
| 62 | REFLECTION_CHECK_REPLY | VAR_BYTE | Reflection check reply |
| 63 | IF_BUTTON4 | 8 | Interface button 4 |
| 64 | OPPLAYERT | 11 | Op player with target |
| 65 | IGNORELIST_DEL | VAR_BYTE | Delete from ignore list |
| 66 | RESUME_PAUSEBUTTON | 6 | Resume pause button |
| 67 | IF_BUTTON7 | 8 | Interface button 7 |
| 68 | FRIENDLIST_ADD | VAR_BYTE | Add to friend list |
| 69 | MOVE_GAMECLICK | VAR_BYTE | Move game click |
| 70 | FRIENDCHAT_JOIN_LEAVE | VAR_BYTE | Friend chat join/leave |
| 71 | MOVE_MINIMAPCLICK | VAR_BYTE | Move minimap click |
| 72 | OPNPC2 | 3 | Op NPC 2 |
| 73 | OPOBJ2 | 7 | Op object 2 |
| 74 | SET_CHATFILTERSETTINGS | 3 | Set chat filter settings |
| 75 | IGNORELIST_ADD | VAR_BYTE | Add to ignore list |
| 76 | NO_TIMEOUT | 0 | No timeout |
| 77 | OPOBJ6 | 6 | Op object 6 |
| 78 | TELEPORT | 9 | Teleport |
| 79 | FRIENDCHAT_KICK | VAR_BYTE | Friend chat kick |
| 80 | IF_BUTTON1 | 8 | Interface button 1 |
| 81 | OCULUS_LEAVE | 0 | Oculus leave |
| 82 | EVENT_APPLET_FOCUS | 1 | Applet focus event |
| 83 | CLIENT_CHEAT | VAR_BYTE | Client cheat |
| 84 | EVENT_MOUSE_MOVE | VAR_BYTE | Mouse move event |
| 85 | IF_BUTTON6 | 8 | Interface button 6 |
| 86 | IF_BUTTON9 | 8 | Interface button 9 |
| 87 | OPNPC6 | 2 | Op NPC 6 |
| 88 | OPOBJ4 | 7 | Op object 4 |
| 89 | OPLOC1 | 7 | Op location 1 |
| 90 | IF_BUTTON5 | 8 | Interface button 5 |
| 91 | RESUME_P_STRINGDIALOG | VAR_BYTE | Resume string dialog |
| 92 | OPPLAYER8 | 3 | Op player 8 |
| 93 | EVENT_MOUSE_SCROLL | 2 | Mouse scroll event |
| 94 | OPOBJT | 15 | Op object with target |
| 95 | EVENT_KEYBOARD | VAR_SHORT | Keyboard event |
| 96 | DETECT_MODIFIED_CLIENT | 4 | Detect modified client |
| 97 | OPLOCU | 15 | Op location with target |
| 98 | CONNECTION_TELEMETRY | VAR_BYTE | Connection telemetry |
| 99 | OPOBJ1 | 7 | Op object 1 |
| 100 | OPPLAYER4 | 3 | Op player 4 |
| 101 | IF_BUTTONX | 9 | Interface button X |

### Login Protocols

#### Login Client Protocols (Incoming)
| Opcode | Protocol Name | Description |
|--------|---------------|-------------|
| 14 | INIT_GAME_CONNECTION | Initialize game connection |
| 15 | INIT_JS5REMOTE_CONNECTION | Initialize JS5 remote connection |
| 16 | GAMELOGIN | Game login |
| 18 | GAMERECONNECT | Game reconnect |
| 19 | POW_REPLY | Proof of work reply |
| 21 | UNKNOWN | Unknown |
| 27 | SSL_WEB_CONNECTION | SSL web connection |
| 32 | REMAINING_BETA_ARCHIVE_HASHES | Remaining beta archive hashes |

#### Login Server Protocols (Outgoing)
| Opcode | Protocol Name | Description |
|--------|---------------|-------------|
| 0 | SUCCESSFUL | Successful login |
| 2 | OK | OK response |
| 3 | INVALID_USERNAME_OR_PASSWORD | Invalid username or password |
| 4 | BANNED | Account banned |
| 5 | DUPLICATE | Duplicate login |
| 6 | CLIENT_OUT_OF_DATE | Client out of date |
| 7 | SERVER_FULL | Server full |
| 8 | LOGINSERVER_OFFLINE | Login server offline |
| 9 | IP_LIMIT | IP limit exceeded |
| 10 | BAD_SESSION_ID | Bad session ID |
| 11 | FORCE_PASSWORD_CHANGE | Force password change |
| 12 | NEED_MEMBERS_ACCOUNT | Need members account |
| 13 | INVALID_SAVE | Invalid save |
| 14 | UPDATE_IN_PROGRESS | Update in progress |
| 15 | RECONNECT_OK | Reconnect OK |
| 16 | TOO_MANY_ATTEMPTS | Too many attempts |
| 17 | IN_MEMBERS_AREA | In members area |
| 18 | LOCKED | Account locked |
| 19 | CLOSED_BETA_INVITED_ONLY | Closed beta invited only |
| 20 | INVALID_LOGINSERVER | Invalid login server |
| 21 | HOP_BLOCKED | Hop blocked |
| 22 | INVALID_LOGIN_PACKET | Invalid login packet |
| 23 | LOGINSERVER_NO_REPLY | Login server no reply |
| 24 | LOGINSERVER_LOAD_ERROR | Login server load error |
| 25 | UNKNOWN_REPLY_FROM_LOGINSERVER | Unknown reply from login server |
| 26 | IP_BLOCKED | IP blocked |
| 27 | SERVICE_UNAVAILABLE | Service unavailable |
| 29 | DISALLOWED_BY_SCRIPT | Disallowed by script |
| 31 | DISPLAYNAME_REQUIRED | Display name required |
| 32 | NEGATIVE_CREDIT | Negative credit |
| 35 | INVALID_SINGLE_SIGNON | Invalid single sign-on |
| 36 | NO_REPLY_FROM_SINGLE_SIGNON | No reply from single sign-on |
| 37 | PROFILE_BEING_EDITED | Profile being edited |
| 38 | NO_BETA_ACCESS | No beta access |
| 39 | INSTANCE_INVALID | Instance invalid |
| 40 | INSTANCE_NOT_SPECIFIED | Instance not specified |
| 41 | INSTANCE_FULL | Instance full |
| 42 | IN_QUEUE | In queue |
| 43 | ALREADY_IN_QUEUE | Already in queue |
| 44 | BILLING_TIMEOUT | Billing timeout |
| 45 | NOT_AGREED_TO_NDA | Not agreed to NDA |
| 47 | EMAIL_NOT_VALIDATED | Email not validated |
| 50 | CONNECT_FAIL | Connect fail |
| 55 | PRIVACY_POLICY | Privacy policy |
| 56 | AUTHENTICATOR | Authenticator |
| 57 | INVALID_AUTHENTICATOR_CODE | Invalid authenticator code |
| 61 | UPDATE_DOB | Update date of birth |
| 62 | TIMEOUT | Timeout |
| 63 | KICK | Kick |
| 64 | RETRY | Retry |
| 65 | LOGIN_FAIL_1 | Login fail 1 |
| 67 | LOGIN_FAIL_2 | Login fail 2 |
| 68 | OUT_OF_DATE_RELOAD | Out of date reload |
| 69 | PROOF_OF_WORK | Proof of work |
| 71 | DOB_ERROR | Date of birth error |
| 72 | WEBSITE_DOB | Website date of birth |
| 73 | DOB_REVIEW | Date of birth review |
| 74 | CLOSED_BETA | Closed beta |

### JS5 Protocols (Cache System)

#### JS5 Client Protocols (Incoming)
| Opcode | Protocol Name | Description |
|--------|---------------|-------------|
| 0 | PREFETCH_REQUEST | Prefetch request |
| 1 | URGENT_REQUEST | Urgent request |
| 2 | PRIORITY_CHANGE_HIGH | Priority change high |
| 3 | PRIORITY_CHANGE_LOW | Priority change low |
| 4 | XOR_CHANGE | XOR change |

## Protocol Categories

### Interface Protocols
- Interface manipulation (IF_*)
- Button handling (IF_BUTTON*)
- Text, color, animation settings

### Movement Protocols
- Player movement (MOVE_*)
- Camera control (CAM_*)
- Teleportation

### Interaction Protocols
- Object interaction (OPOBJ*)
- NPC interaction (OPNPC*)
- Player interaction (OPPLAYER*)
- Location interaction (OPLOC*)

### Communication Protocols
- Private messaging
- Public messaging
- Friend system
- Clan system
- Friend chat

### Game State Protocols
- Inventory updates
- Stats updates
- Variable player (VARP)
- Map updates
- Zone updates

### Audio Protocols
- MIDI music
- Sound effects
- Jingle management

### Security Protocols
- Reflection checks
- Client detection
- Authentication
- Proof of work

## Version Information

This protocol summary covers OSRS protocol versions 221-231, with the detailed breakdown shown for version 231. Each version may have slight variations in opcode assignments and protocol definitions.

## Usage Notes

- **VAR_BYTE** (-1): Variable length byte
- **VAR_SHORT** (-2): Variable length short
- **Fixed sizes**: Positive integers indicate fixed packet sizes
- **Deprecated protocols**: Some protocols are marked as deprecated and should use newer alternatives

## Protocol Architecture

The rsprot library uses a modular architecture with:
- **API layer**: High-level protocol management
- **Model layer**: Protocol definitions and structures
- **Internal layer**: Implementation details
- **Desktop layer**: Client-specific implementations
- **Shared layer**: Common utilities and constants

This architecture allows for clean separation of concerns and easy maintenance across multiple OSRS versions. 